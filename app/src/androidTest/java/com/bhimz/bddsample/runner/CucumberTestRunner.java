package com.bhimz.bddsample.runner;

import android.os.Bundle;


import cucumber.api.android.CucumberAndroidJUnitRunner;

public class CucumberTestRunner extends CucumberAndroidJUnitRunner {

    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
    }
}
