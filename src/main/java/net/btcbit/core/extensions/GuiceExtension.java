package net.btcbit.core.extensions;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import net.btcbit.core.guiceconfiguration.BasicModule;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class GuiceExtension implements ParameterResolver, TestInstancePostProcessor {

    private final Injector injector;

    public GuiceExtension() {
        injector = Guice.createInjector(new BasicModule());
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().isAnnotationPresent(Inject.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return injector.getInstance(parameterContext.getParameter().getType());
    }

    @Override
    public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {
        injector.injectMembers(o);
    }
}
