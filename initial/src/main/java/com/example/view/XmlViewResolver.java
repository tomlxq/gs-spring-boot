package com.example.view;

/**
 * Created by tom on 2016/5/15.
 */

import com.example.domain.Account;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Locale;


public class XmlViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        MarshallingView view = new MarshallingView();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Account.class);
        marshaller.setPackagesToScan("com.example.domain");
        view.setMarshaller(marshaller);
        return view;
    }

}