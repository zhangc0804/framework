/*
@VaadinApache2LicenseForJavaFiles@
 */
package com.vaadin.terminal.gwt.client;

import com.google.gwt.core.client.RunAsyncCallback;

/** A helper class used by WidgetMap implementation. Used by the generated code. */
abstract class WidgetLoader implements RunAsyncCallback {

    @Override
    public void onFailure(Throwable reason) {
        ApplicationConfiguration.endDependencyLoading();
    }

    @Override
    public void onSuccess() {
        addInstantiator();
        ApplicationConfiguration.endDependencyLoading();
    }

    abstract void addInstantiator();
}
