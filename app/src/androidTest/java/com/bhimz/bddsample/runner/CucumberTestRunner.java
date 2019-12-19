package com.bhimz.bddsample.runner;

import android.os.Bundle;

import androidx.test.runner.AndroidJUnitRunner;

import cucumber.api.android.CucumberInstrumentationCore;

public class CucumberTestRunner extends AndroidJUnitRunner {
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle arguments) {
        instrumentationCore.create(arguments);
        super.onCreate(arguments);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
