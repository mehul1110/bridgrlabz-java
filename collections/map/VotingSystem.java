package collections.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Design a Voting System
 * - Votes stored in HashMap (Candidate -> Votes)
 * - TreeMap used to display results in sorted order (by Candidate Name? or by
 * Votes?
 * Ref assumes sorted order usually implies key sorting in TreeMap aka Candidate
 * Name.
 * If needed by Votes, we need a ValueComparator or just sort entries).
 * "TreeMap is used to display the results in sorted order." -> Usually implies
 * keys.
 * - LinkedHashMap used to maintain the order of votes (insertion/processing
 * order).
 */
public class VotingSystem {

    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> recordedVotesLog = new LinkedHashMap<>(); // Log of current state in order

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        // Updating insertion order map is tricky as keys are unique.
        // LinkedHashMap naturally updates access order if configured,
        // or effectively just re-inserting moves it to end? No, put only existing
        // doesn't change order unless accessOrder=true.
        // Let's assume we want to track who got voted for in order.
        // But "LinkedHashMap is used to maintain the order of votes" in the context of
        // (Candidate->Votes) map usually means insertion order of candidates into the
        // system?
        // Or tracking the order in which candidates received their *latest* vote?
        // Let's assume: Insertion order of candidates.
        if (!recordedVotesLog.containsKey(candidate)) {
            recordedVotesLog.put(candidate, 1);
        } else {
            recordedVotesLog.put(candidate, voteMap.get(candidate));
        }
    }

    public void displayResultsSortedAlpha() {
        System.out.println("\nResults (Sorted Alphabetically via TreeMap):");
        Map<String, Integer> sorted = new TreeMap<>(voteMap);
        System.out.println(sorted);
    }

    public void displayVotesInInsertionOrder() {
        System.out.println("\nVotes (Insertion Order via LinkedHashMap):");
        System.out.println(recordedVotesLog);
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.castVote("Bob");
        vs.castVote("Alice");
        vs.castVote("Bob");
        vs.castVote("Charlie");

        // Bob: 2, Alice: 1, Charlie: 1.
        // Insertion order of keys: Bob, Alice, Charlie.
        // Sorted order: Alice, Bob, Charlie.

        System.out.println("Vote Map (HashMap - Unordered): " + vs.voteMap);
        vs.displayResultsSortedAlpha();
        vs.displayVotesInInsertionOrder();
    }
}
