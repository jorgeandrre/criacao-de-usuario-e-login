package com.jorge.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository userRepository;
    
    //GET ALL
    public List<Usuario> getAllUsers(final Integer pageNo, final Integer pageSize, final String sortBy) {
        final Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Usuario> pagedResult = userRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Usuario>();
		}
    }
    
    // GET ONE
	public Usuario getUser(final Long id) {
		return userRepository.findOne(Long.toString(id));
    }
    
    //DELETE ONE
    public void deleteUser(final Long id) {
		Usuario user =  userRepository.findOne(Long.toString(id));
		userRepository.delete(user);
	}
}