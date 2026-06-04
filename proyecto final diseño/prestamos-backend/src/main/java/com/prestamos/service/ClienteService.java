package com.prestamos.service;

import com.prestamos.dto.ClienteDTO;
import com.prestamos.model.Cliente;
import com.prestamos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO registrarCliente(ClienteDTO dto) {
        if (clienteRepository.existsByCedula(dto.getCedula())) {
            throw new RuntimeException("Ya existe un cliente con la cedula: " + dto.getCedula());
        }
        Cliente cliente = new Cliente(dto.getNombre(), dto.getCedula(), dto.getTelefono(),
                dto.getDireccion(), dto.getCorreo());
        return toDTO(clienteRepository.save(cliente));
    }

    public ClienteDTO actualizarCliente(String id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        cliente.actualizar(dto.getNombre(), dto.getTelefono(), dto.getDireccion(), dto.getCorreo());
        return toDTO(clienteRepository.save(cliente));
    }

    public ClienteDTO consultarCliente(String id) {
        return clienteRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
    }

    public List<ClienteDTO> consultarTodos() {
        return clienteRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void eliminarCliente(String id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado: " + id);
        }
        clienteRepository.deleteById(id);
    }

    public boolean validarCliente(String id) {
        return clienteRepository.existsById(id);
    }

    public ClienteDTO toDTO(Cliente c) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setCedula(c.getCedula());
        dto.setTelefono(c.getTelefono());
        dto.setDireccion(c.getDireccion());
        dto.setCorreo(c.getCorreo());
        dto.setFechaRegistro(c.getFechaRegistro());
        dto.setEstado(c.isEstado());
        return dto;
    }
}
