package com.pbarri.vm.api.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by pablo on 13/12/16.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // TODO: Hacer efectiva la configuración

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
