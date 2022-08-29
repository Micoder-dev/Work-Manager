package com.example.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DemoWorker extends Worker {

    public static final String KEY_WORKER = "Sent";


    public DemoWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /**
     * The doWork() method runs asynchronously
     * on a background thread provided by WorkManager
     **/
    @NonNull
    @Override
    public Result doWork() {

        // Do the work here--in this case, count to the passed number:

        // Getting the Data from InputData
        Data data = getInputData();
        int countingLimit = data.getInt(MainActivity.KEY_COUNTER_VALUE, 0);

        for (int i = 0; i<countingLimit; i++ ) {
            Log.i("TAGY", "Count is : "+i);
        }

        // Sending Data and Done Info
        Data dataToSend = new Data.Builder().putString(KEY_WORKER, "Task Done Successfully").build();

        // The Result returned from doWork() informs the
        // WorkManager service whether the work succeeded and,
        // in the case of failure, whether or not the work should be retried.
        //  - Result.success(): The work finished successfully.
        //  - Result.failure(): The work failed.
        //  - Result.retry():   The work failed and should be tried at
        //                      another time according to its retry policy
        return Result.success(dataToSend);
    }
}
