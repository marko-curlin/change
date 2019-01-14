package mediatoolkit.mcurlin.change.service.impl;

import mediatoolkit.mcurlin.change.domain.expense.Expense;
import mediatoolkit.mcurlin.change.domain.income.Income;
import mediatoolkit.mcurlin.change.domain.interchange.Interchange;
import mediatoolkit.mcurlin.change.domain.user.User;
import mediatoolkit.mcurlin.change.domain.user.UserRequest;
import mediatoolkit.mcurlin.change.domain.user.UserResponse;
import mediatoolkit.mcurlin.change.repository.UserRepository;
import mediatoolkit.mcurlin.change.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addIncome(Income income) {
        User userReceivedIncome = income.getUserReceivedIncome();

        userReceivedIncome.addIncome(income);
        userReceivedIncome.setBalance(userReceivedIncome.getBalance() - income.getAmount());
        userRepository.save(userReceivedIncome);

        List<User> usersParticipatedInIncome = income.getUsersParticipatedInIncome();
        int numberOfParticipants = usersParticipatedInIncome.size();
        for(User user : usersParticipatedInIncome){
            user.addIncome(income);
            user.setBalance(user.getBalance() + income.getAmount()/numberOfParticipants);
            userRepository.save(user);
        }
    }

    @Override
    public UserResponse add(UserRequest userRequest) {
        return getUserResponse(userRepository.save(new User(userRequest)));
    }

    @Override
    public UserResponse getById(Long userId) {
        return getUserResponse(userRepository.getById(userId));
    }

    @Override
    public void addExpense(Expense expense) {
        User userReceivedExpense = expense.getUserReceivedExpense();

        userReceivedExpense.addExpense(expense);
        userReceivedExpense.setBalance(userReceivedExpense.getBalance() + expense.getAmount());
        userRepository.save(userReceivedExpense);

        List<User> usersParticipatedInExpense = expense.getUsersParticipatedInExpense();
        int numberOfParticipants = usersParticipatedInExpense.size();
        for(User user : usersParticipatedInExpense){
            user.addExpense(expense);
            user.setBalance(user.getBalance() - expense.getAmount()/numberOfParticipants);
            userRepository.save(user);
        }
    }

    @Override
    public void addInterchange(Interchange interchange) {
        User userGiver = interchange.getUserGiver();
        User userReceiver = interchange.getUserReceiver();

        userGiver.addInterchange(interchange);
        userReceiver.addInterchange(interchange);

        userGiver.setBalance(userGiver.getBalance() + interchange.getAmount());
        userReceiver.setBalance(userReceiver.getBalance() - interchange.getAmount());

        userRepository.save(userGiver);
        userRepository.save(userReceiver);
    }

    @Override
    public List<UserResponse> getAll() {
        Iterable<User> allUsers = userRepository.findAll();
        List<UserResponse> allUsersResponse = new ArrayList<>();

        for(User user : allUsers){
            allUsersResponse.add(new UserResponse(user));
        }

        return allUsersResponse;
    }

    private UserResponse getUserResponse(User user) {
        return new UserResponse(user);
    }
}
