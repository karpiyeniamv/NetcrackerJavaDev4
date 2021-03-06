package com.assignstudent.etalon.converters;

import com.assignstudent.etalon.beans.SpecialtyViewModel;
import com.assignstudent.etalon.entities.SpecialtyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class SpecialtyEntityToSpecialtyViewModelConverter implements Converter<SpecialtyEntity,SpecialtyViewModel>{
    @Autowired
    private ConversionService conversionService;

    @Override
    public SpecialtyViewModel convert (SpecialtyEntity specialtyEntity){
        SpecialtyViewModel specialtyViewModel=new SpecialtyViewModel();
        specialtyViewModel.setId(specialtyEntity.getId());
        specialtyViewModel.setSpecialtyName(specialtyEntity.getSpecialtyName());
      //  specialtyViewModel.setFacultyByFacultyId(conversionService.convert(specialtyEntity.getFacultyByFacultyId(), FacultyViewModel.class));
        return specialtyViewModel;
    }
}
