package mediatoolkit.mcurlin.change.service.impl;

import mediatoolkit.mcurlin.change.domain.interchange.Interchange;
import mediatoolkit.mcurlin.change.domain.interchange.InterchangeRequest;
import mediatoolkit.mcurlin.change.domain.interchange.InterchangeResponse;
import mediatoolkit.mcurlin.change.domain.user.User;
import mediatoolkit.mcurlin.change.repository.InterchangeRepository;
import mediatoolkit.mcurlin.change.repository.UserRepository;
import mediatoolkit.mcurlin.change.service.InterchangeService;
import mediatoolkit.mcurlin.change.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterchangeServiceImpl implements InterchangeService {

    private final InterchangeRepository interchangeRepository;
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public InterchangeServiceImpl(InterchangeRepository interchangeRepository) {
        this.interchangeRepository = interchangeRepository;
    }

    @Override
    public InterchangeResponse add(InterchangeRequest interchangeRequest) {
        User userReceiver = userRepository.getById(interchangeRequest.getUserReceiverId());
        User userGiver = userRepository.getById(interchangeRequest.getUserGiverId());

        if(userReceiver == null || userGiver == null){
            return null;
        }

        Interchange interchange = new Interchange(interchangeRequest);
        interchange.setUserGiver(userGiver);
        interchange.setUserReceiver(userReceiver);

        userService.addInterchange(interchange);

        return new InterchangeResponse(interchangeRepository.save(interchange));

    }
}
