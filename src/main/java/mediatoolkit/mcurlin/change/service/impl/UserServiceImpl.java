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
        List<User> usersParticipatedInIncome = income.getUsersParticipatedInIncome();
        int numberOfParticipants = usersParticipatedInIncome.size()+1;

        userReceivedIncome.addParticipatedIncome(income);
        userReceivedIncome.setBalance(userReceivedIncome.getBalance() - income.getAmount() * (double)(numberOfParticipants-1)/numberOfParticipants);
        userRepository.save(userReceivedIncome);


        for(User user : usersParticipatedInIncome){
            user.addParticipatedIncome(income);
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
        List<User> usersParticipatedInExpense = expense.getUsersParticipatedInExpense();
        int numberOfParticipants = usersParticipatedInExpense.size()+1;

        userReceivedExpense.addParticipatedExpense(expense);
        userReceivedExpense.setBalance(userReceivedExpense.getBalance() + expense.getAmount() * (double)(numberOfParticipants-1)/numberOfParticipants);
        userRepository.save(userReceivedExpense);

        for(User user : usersParticipatedInExpense){
            user.addParticipatedExpense(expense);
            user.setBalance(user.getBalance() - expense.getAmount()/numberOfParticipants);
            userRepository.save(user);
        }
    }

    @Override
    public void addInterchange(Interchange interchange) {
        User userGiver = interchange.getUserGiver();
        User userReceiver = interchange.getUserReceiver();

        userGiver.addReceivedInterchange(interchange);
        userReceiver.addReceivedInterchange(interchange);

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
