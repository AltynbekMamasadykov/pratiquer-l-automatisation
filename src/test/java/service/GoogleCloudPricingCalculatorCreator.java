package service;

import model.GoogleCloudPricingCalculator;

public class GoogleCloudPricingCalculatorCreator {

   private static final String TEST_INSTANCE_NUMBER = "calculator.numberOfInstances";
   private static final String TEST_OPERATING_SYSTEM = "calculator.operationSystem";
   private static final String TEST_PROVISIONING_MODEL = "calculator.provisioningModel";
   private static final String TEST_SERIES = "calculator.series";
   private static final String TEST_MACHINE_TYPE = "calculator.machineType";
   private static final String TEST_GPU_TYPE = "calculator.GPUType";
   private static final String TEST_NUMBER_OF_GPU = "calculator.numberOfGPU";
   private static final String TEST_LOCAL_SSD = "calculator.localSSD";
   private static final String TEST_DATA_CENTER_LOCATION = "calculator.datacenterLocation";
   private static final String TEST_COMMITTED_USAGE = "calculator.committedUsage";

    public static GoogleCloudPricingCalculator withProperty() {
        GoogleCloudPricingCalculator calculator =  new GoogleCloudPricingCalculator();
        calculator.setNumberOfInstances(TestDataReader.getTestData(TEST_INSTANCE_NUMBER));
        calculator.setOperationSystem(TestDataReader.getTestData(TEST_OPERATING_SYSTEM));
        calculator.setProvisioningModel(TestDataReader.getTestData(TEST_PROVISIONING_MODEL));
        calculator.setSeries(TestDataReader.getTestData(TEST_SERIES));
        calculator.setMachineType(TestDataReader.getTestData(TEST_MACHINE_TYPE));
        calculator.setNumberOfGPU(TestDataReader.getTestData(TEST_NUMBER_OF_GPU));
        calculator.setGPUType(TestDataReader.getTestData(TEST_GPU_TYPE));
        calculator.setLocalSSD(TestDataReader.getTestData(TEST_LOCAL_SSD));
        calculator.setDatacenterLocation(TestDataReader.getTestData(TEST_DATA_CENTER_LOCATION));
        calculator.setCommittedUsage(TestDataReader.getTestData(TEST_COMMITTED_USAGE));
        return calculator;
    }

}
