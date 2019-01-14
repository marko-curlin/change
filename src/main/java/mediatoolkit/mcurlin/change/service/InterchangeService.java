package mediatoolkit.mcurlin.change.service;

import mediatoolkit.mcurlin.change.domain.interchange.InterchangeRequest;
import mediatoolkit.mcurlin.change.domain.interchange.InterchangeResponse;
import org.springframework.stereotype.Service;

@Service
public interface InterchangeService {
    InterchangeResponse add(InterchangeRequest interchangeRequest);
}
