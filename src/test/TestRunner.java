package test;

import java.io.PrintWriter;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;



public class TestRunner {
    public static void main(String args[]){

        // creating request for launching test cases.
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        // set package to test package.
                        DiscoverySelectors.selectPackage("test")
                )
                .build();

        // create a new Launcher
        Launcher launcher = LauncherFactory.create();

        // register a listener to collect test summary
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        // run the tests
        launcher.execute(request);

        // print the test summary
        TestExecutionSummary summary = listener.getSummary();

        summary.printTo(new PrintWriter(System.out));

        // check for failed tests and print details
        if (summary.getFailures().size() > 0) {
            System.out.println("\nFailed Tests:");
            summary.getFailures().forEach(failure -> {
                System.out.println("Test Identifier: " + failure.getTestIdentifier().getDisplayName());
                System.out.println("Exception Message: " + failure.getException().getMessage());
                failure.getException().printStackTrace();
            });
        } else {
            System.out.println("\nAll tests passed successfully!");
        }
    }
}
