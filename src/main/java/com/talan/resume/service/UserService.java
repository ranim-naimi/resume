package com.talan.resume.service;

import com.talan.resume.model.User;
import com.talan.resume.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create (UserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dateOfBirth(request.getDateOfBirth())
                .city(request.getCity())
                .country(request.getCountry())
                .phone(request.getPhone())
                .email(request.getEmail())
                .address(request.getAddress())
                .graduation(request.getGraduation())
                .university(request.getUniversity())
                .degree(request.getDegree())
                .companyName(request.getCompanyName())
                .jobPosition(request.getJobPosition())
                .fromDate(request.getFromDate())
                .toDate(request.getToDate())
                .skills(request.getSkills())
                .motivation(request.getMotivation())
                .build();

        return userRepository.save(user);

    }

    public List<User> findAllUsers () {
        return userRepository.findAll() ;
    }
    public Optional<User> findUserById(Long id ) {

        return userRepository.findById(id);
    }

    public <U extends User> U save(U u) {

        return userRepository.save(u);
    }

    public void deleteUserById (Long id) {
        userRepository.deleteById(id);
    }

}
