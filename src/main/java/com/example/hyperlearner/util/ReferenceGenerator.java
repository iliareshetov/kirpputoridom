package com.example.hyperlearner.util;

import com.example.hyperlearner.service.AppointmentService;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
@Configurable
public class ReferenceGenerator  {

    @Autowired
    private AppointmentService appointmentService;

    private static ReferenceGenerator referenceGenerator = null;

    private ReferenceGenerator()
    {

    }

    public static ReferenceGenerator getInstance()
    {
        if (referenceGenerator == null)
            referenceGenerator = new ReferenceGenerator();

        return referenceGenerator;
    }



}
