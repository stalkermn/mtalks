package com.mtalks.v1.service;

import com.mtalks.v1.domain.Confirm;

import java.util.List;

/**
 * User: vvasil
 * Date: 3/27/13
 * Time: 11:43 PM
 */
public interface ConfirmService {
    public Confirm save(Confirm basicUser);

    public List<Confirm> findAll();

    public Confirm findByToken(String token);

    public void delete(Confirm id);

    public void deleteByToken(String token);

    public Confirm findByEmail(String email);
}
