package com.example.demo.bl;

import com.example.demo.dto.PeopleDto;
import com.example.demo.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleBl {

    @Autowired
    private com.example.demo.repository.PeopleRepository PeopleRepository;

    @Autowired
    private com.example.demo.dao.PeopleDao PeopleDao;


    public People save(People newpeople){
        return PeopleRepository.save(newpeople);
    }

//    public List<PeopleDto> getAllPeople(){
//        List<People> peoplei = PeopleDao.getAllPeople();
//        List<PeopleDto> res = new ArrayList<>();
//        peoplei.forEach(people ->{
//            res.add(new PeopleDto(people.getIdPersona(),people.getNombre(),people.getApellido(),people.getEdad(),people.getCorreo(),people.getContrasena(),people.getTelefono(),people.getDireccion(),people.getFechaNacimiento(),people.getGenero(),people.getEstadoCivil(),people.getTipoPersona(),people.getTipoDocumento(),people.getNumeroDocumento(),people.getRol()));
//        });
//        return res;
//    }

}
