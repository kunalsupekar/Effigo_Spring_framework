package com.effigo.tools.support_api.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.tools.support_api.dto.RoleDTO;
import com.effigo.tools.support_api.model.Role;
import com.effigo.tools.support_api.repository.RoleRepository;
import com.effigo.tools.support_api.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        Role savedRole = roleRepository.save(role);
        return modelMapper.map(savedRole, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                             .stream()
                             .map(role -> modelMapper.map(role, RoleDTO.class))
                             .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return roleRepository.findById(id)
                             .map(role -> modelMapper.map(role, RoleDTO.class))
                             .orElse(null);
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        if (roleRepository.existsById(id)) {
            Role role = modelMapper.map(roleDTO, Role.class);
            role.setId(id);
            Role updatedRole = roleRepository.save(role);
            return modelMapper.map(updatedRole, RoleDTO.class);
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
