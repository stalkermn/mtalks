package com.mtalks.v1.service.registration;

import com.mtalks.v1.dao.ConfirmRepository;
import com.mtalks.v1.domain.Confirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: vvasil
 * Date: 3/27/13
 * Time: 11:46 PM
 */
@Service
@Transactional
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    ConfirmRepository confirmRepository;

    @Transactional
    @Override
    public Confirm save(Confirm confirm) {
        return confirmRepository.save(confirm);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Confirm> findAll() {
        return confirmRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Confirm findByToken(String token) {
        return confirmRepository.findByToken(token);
    }

    @Transactional
    @Override
    public void delete(Confirm confirm) {
        confirmRepository.delete(confirm);
    }

    @Transactional
    @Override
    public void deleteByToken(final String token) {
        confirmRepository.delete(new Confirm(){{setToken(token);}});
    }

    @Transactional(readOnly = true)
    @Override
    public Confirm findByEmail(String email) {
        return confirmRepository.findByEmail(email);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
