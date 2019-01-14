package mediatoolkit.mcurlin.change.service.impl;

import mediatoolkit.mcurlin.change.domain.income.Income;
import mediatoolkit.mcurlin.change.domain.income.IncomeRequest;
import mediatoolkit.mcurlin.change.domain.income.IncomeResponse;
import mediatoolkit.mcurlin.change.domain.user.User;
import mediatoolkit.mcurlin.change.repository.IncomeRepository;
import mediatoolkit.mcurlin.change.repository.UserRepository;
import mediatoolkit.mcurlin.change.service.IncomeService;
import mediatoolkit.mcurlin.change.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository, UserRepository userRepository, UserService userService) {
        this.incomeRepository = incomeRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public IncomeResponse add(IncomeRequest incomeRequest) {
        User userReceivedIncome = userRepository.getById(incomeRequest.getUserReceivedIncomeId());

        if(userReceivedIncome == null){
            return null;
        }

        List<User> userParticipatedInIncome = new ArrayList<>();

        for(Long userId : incomeRequest.getUsersParticipatedInIncomeId()){
            User user = userRepository.getById(userId);
            if(user == null){
                continue;
            }
            userParticipatedInIncome.add(user);
        }

        Income income = new Income(incomeRequest);

        income.setUserReceivedIncome(userReceivedIncome);
        income.setUsersParticipatedInIncome(userParticipatedInIncome);

        userService.addIncome(income);

        return new IncomeResponse(incomeRepository.save(income));
    }

    @Override
    public IncomeResponse getById(Long incomeId) {
        return new IncomeResponse(incomeRepository.getById(incomeId));
    }

}
