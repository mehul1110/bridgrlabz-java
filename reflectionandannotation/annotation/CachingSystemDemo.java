package reflectionandannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Practice Problem 7: Implement a Custom Caching System with @CacheResult
 */

// Step 1: Definition of the custom runtime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Caching applies to method outputs
@interface CacheResult {
}

// Step 2: Decorating methods within a business logic processing class
class HeavyDataProcessor {

    // Flag this method logic execution output map as cacheable
    @CacheResult
    public int computeFactorial(int numberTarget) {
        System.out.println("Processing computationally heavy logic for Target: '" + numberTarget + "'...");
        try {
            // Simulated long execution block
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int logicResult = 1;
        for (int i = 1; i <= numberTarget; i++) {
            logicResult *= i;
        }
        return logicResult;
    }
}

public class CachingSystemDemo {

    // Global Storage block mapped to argument identity logic inputs and values
    private static final Map<String, Object> methodResultCache = new HashMap<>();

    public static Object executeWithCache(Object executingObjectInstance, String methodName, Object[] args,
            Class<?>[] paramTypes) {
        try {
            Class<?> objectType = executingObjectInstance.getClass();
            Method processingMethod = objectType.getMethod(methodName, paramTypes);

            // Constructing a unique logical Cache Mapping Key System string based on Method
            // Name + parameter
            String cacheKey = processingMethod.getName() + "-" + (args.length > 0 ? args[0].toString() : "null");

            // Evaluate Annotation System Requirement Logic
            if (processingMethod.isAnnotationPresent(CacheResult.class)) {

                // Verify memory existence
                if (methodResultCache.containsKey(cacheKey)) {
                    System.out.println(
                            "[CACHE SYSTEM HIT] Retrieved existing computed map for Target: '" + args[0] + "'");
                    return methodResultCache.get(cacheKey);
                }
            }

            // Normal Execution execution pipeline
            System.out.println("[CACHE SYSTEM MISS] Fetching map output through live computation...");
            Object outputExecutionResult = processingMethod.invoke(executingObjectInstance, args);

            // Record execution cache object mapping result
            if (processingMethod.isAnnotationPresent(CacheResult.class)) {
                methodResultCache.put(cacheKey, outputExecutionResult);
            }

            return outputExecutionResult;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Method Cache Annotator Processing Evaluator ---\n");
        HeavyDataProcessor dataProcessorObj = new HeavyDataProcessor();

        System.out.println("Calling computeFactorial logic for (5) [Execution #1 - Cache Miss Request Action]");
        Object executionOutputOne = executeWithCache(dataProcessorObj, "computeFactorial", new Object[] { 5 },
                new Class<?>[] { int.class });
        System.out.println("Result -> " + executionOutputOne + "\n");

        System.out.println("Calling computeFactorial logic for (5) [Execution #2 - Cached Request]");
        Object executionOutputTwo = executeWithCache(dataProcessorObj, "computeFactorial", new Object[] { 5 },
                new Class<?>[] { int.class });
        System.out.println("Result -> " + executionOutputTwo + "\n");

        System.out.println("Calling computeFactorial logic for (7) [Execution #3 - Cache Miss Request Action]");
        Object executionOutputThree = executeWithCache(dataProcessorObj, "computeFactorial", new Object[] { 7 },
                new Class<?>[] { int.class });
        System.out.println("Result -> " + executionOutputThree + "\n");

        System.out.println("Calling computeFactorial logic for (7) [Execution #4 - Cached Request Action]");
        Object executionOutputFour = executeWithCache(dataProcessorObj, "computeFactorial", new Object[] { 7 },
                new Class<?>[] { int.class });
        System.out.println("Result -> " + executionOutputFour + "\n");
    }
}
