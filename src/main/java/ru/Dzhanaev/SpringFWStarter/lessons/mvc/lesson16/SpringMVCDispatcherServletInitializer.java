package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson16;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Artur Dzhanaev
 * @created 04.01.2023
 */
@Slf4j
public class SpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() { return null; }

    @Override
    protected Class<?>[] getServletConfigClasses() { return new Class[] { SpringConfig.class }; }

    @Override
    protected String @NotNull [] getServletMappings() { return new String[] {"/"}; }
}
