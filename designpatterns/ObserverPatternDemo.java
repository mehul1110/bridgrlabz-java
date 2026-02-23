package designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern implementation.
 * Defines a one-to-many dependency so that when one object changes state, all
 * its dependents are notified.
 */

// Step 1: Observer Interface outlining receiving notification structural
// requirements
interface SubscriberObserver {
    void processStateUpdate(String latestNewsHeadlineToUpdate);
}

// Step 2: Subject Interface mapping subscription logical events properties
interface NewsAgencySubject {
    void attachObserverToSubList(SubscriberObserver genericObserverObj);

    void detachObserverFromSubList(SubscriberObserver genericObserverObj);

    void broadcastStateNotification();
}

// Step 3: Concrete Subject mapping dynamic changes logic variables
// configuration memory
class RegionalNewsAgencyBroadcaster implements NewsAgencySubject {
    private List<SubscriberObserver> registeredSubscribersList;
    private String breakingNewsFlashHighlightStr;

    public RegionalNewsAgencyBroadcaster() {
        this.registeredSubscribersList = new ArrayList<>();
    }

    public void updatePublishNewBreakingHeadline(String targetPublishNews) {
        System.out.println("--- [System Update] News Agency just generated a new Breaking Flash! ---");
        this.breakingNewsFlashHighlightStr = targetPublishNews;

        // Logical Event sequence delegates mapping broadcasting property execution
        // automatically
        this.broadcastStateNotification();
    }

    @Override
    public void attachObserverToSubList(SubscriberObserver targetSubContextObj) {
        registeredSubscribersList.add(targetSubContextObj);
        System.out.println("Registered a new Target Consumer System logic component.");
    }

    @Override
    public void detachObserverFromSubList(SubscriberObserver genericObserverObj) {
        registeredSubscribersList.remove(genericObserverObj);
        System.out.println("Removed a mapped Consumer System sub component.");
    }

    @Override
    public void broadcastStateNotification() {
        // Iterate all registered list objects and ping them dynamically referencing
        // context
        for (SubscriberObserver listenerTargetObjInstance : registeredSubscribersList) {
            listenerTargetObjInstance.processStateUpdate(this.breakingNewsFlashHighlightStr);
        }
    }
}

// Step 4: Concrete Observers consuming memory Logic State Property variations
// mapping event listeners
class NewsReaderClientChannel implements SubscriberObserver {
    private String subscriberIdentificationIdStr;

    public NewsReaderClientChannel(String targetIdLogicParamName) {
        this.subscriberIdentificationIdStr = targetIdLogicParamName;
    }

    @Override
    public void processStateUpdate(String broadcastNewsExecutionOutput) {
        System.out.println("[Client: " + subscriberIdentificationIdStr + "] Notification Received -> Breaking News!: "
                + broadcastNewsExecutionOutput);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Observer Strategy Pattern Pub/Sub Dynamic Property Architecture...\n");

        System.out.println("Building Source Mapping configuration object (News Agency):");
        RegionalNewsAgencyBroadcaster sourcePublisherHub = new RegionalNewsAgencyBroadcaster();

        // Target Mappings logically isolated configuration structure
        SubscriberObserver endUserObjBob = new NewsReaderClientChannel("User_Bob_Channel_1");
        SubscriberObserver endUserObjAlice = new NewsReaderClientChannel("User_Alice_Channel_2");

        // Subscription linking events registry Execution
        sourcePublisherHub.attachObserverToSubList(endUserObjBob);
        sourcePublisherHub.attachObserverToSubList(endUserObjAlice);

        System.out.println("\nExecuting State Variation Operation on the Agency Object Mapping Reference");
        sourcePublisherHub.updatePublishNewBreakingHeadline("Global Market Hits New High!");

        System.out.println("\n--- Event Series 2 [Alice un-subscribes, Charlie joints] ---");
        sourcePublisherHub.detachObserverFromSubList(endUserObjAlice);

        SubscriberObserver charlieEndObserver = new NewsReaderClientChannel("User_Charlie_Channel_3");
        sourcePublisherHub.attachObserverToSubList(charlieEndObserver);

        // Generating execution sequence notification
        sourcePublisherHub.updatePublishNewBreakingHeadline("Tech Companies announce new major AI framework.");
    }
}
