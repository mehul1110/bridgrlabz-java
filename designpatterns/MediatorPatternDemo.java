package designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Mediator Pattern implementation.
 * Centralizes communication between objects (colleagues) to reduce coupling.
 */

// Step 1: Define Mediator Interface logic mediating properties mapping
// execution
interface ChatMediator {
    void sendMessageFromUser(String messageContent, ChatUser sendingUserInstance);

    // Method handling dynamic registry connection
    void registerNewUser(ChatUser newUserInstance);
}

// Step 2: Define Colleague Class (the communicative instances)
abstract class ChatUser {
    protected ChatMediator mediatorPlatformInstance; // Holding reference mapping execution to Central Hub
    protected String userIdentificationName;

    public ChatUser(ChatMediator assignedCentralMediator, String usernameInput) {
        this.mediatorPlatformInstance = assignedCentralMediator;
        this.userIdentificationName = usernameInput;
    }

    public abstract void pushMessageTransaction(String messageContextData);

    public abstract void receiveBroadCastExecution(String messageContextData);
}

// Step 3: Implement concrete centralized interaction Manager logic Hub Room
class TextChatRoom implements ChatMediator {
    private List<ChatUser> connectedUsersList;

    public TextChatRoom() {
        this.connectedUsersList = new ArrayList<>();
    }

    @Override
    public void registerNewUser(ChatUser userReference) {
        this.connectedUsersList.add(userReference);
    }

    @Override
    public void sendMessageFromUser(String outputMessageExecution, ChatUser sourceMappingUserReference) {
        // Iterate and broadcast to all users *except* the sender instance object
        for (ChatUser targetUserInstanceObj : this.connectedUsersList) {
            if (targetUserInstanceObj != sourceMappingUserReference) {
                targetUserInstanceObj.receiveBroadCastExecution(outputMessageExecution);
            }
        }
    }
}

// Step 4: Concrete Colleague users
class PlatformMemberUser extends ChatUser {
    public PlatformMemberUser(ChatMediator assignedMediator, String userNameInputStr) {
        super(assignedMediator, userNameInputStr);
    }

    @Override
    public void pushMessageTransaction(String messageContextLogicStr) {
        System.out.println("{" + this.userIdentificationName + "}: Sending -> " + messageContextLogicStr);
        // Using central hub configuration execution map routing instead of direct
        // coupling
        mediatorPlatformInstance.sendMessageFromUser(messageContextLogicStr, this);
    }

    @Override
    public void receiveBroadCastExecution(String messageContextLogicStr) {
        System.out.println("{" + this.userIdentificationName + "} Recieved: " + messageContextLogicStr);
    }
}

public class MediatorPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Mediator Pattern Central Hub Processing Executions...\n");

        System.out.println("Configuring Chat Room Engine:");
        ChatMediator centralHubRoomLogic = new TextChatRoom();

        // Establish members mapping reference logically decoupled from one another
        ChatUser u1 = new PlatformMemberUser(centralHubRoomLogic, "Alice");
        ChatUser u2 = new PlatformMemberUser(centralHubRoomLogic, "Bob");
        ChatUser u3 = new PlatformMemberUser(centralHubRoomLogic, "Charlie");

        // Binding instances via the structural Interface method configuration
        centralHubRoomLogic.registerNewUser(u1);
        centralHubRoomLogic.registerNewUser(u2);
        centralHubRoomLogic.registerNewUser(u3);

        System.out
                .println("\nBeginning Transaction Events Configuration mapping through Mediator Architecture System:");

        // Members send data strictly relying on the Central component resolution
        // tracking route
        u1.pushMessageTransaction("Hello everyone in the Chat!");
        System.out.println("\n----------------------------\n");
        u3.pushMessageTransaction("Hi Alice! Good to see you.");
    }
}
