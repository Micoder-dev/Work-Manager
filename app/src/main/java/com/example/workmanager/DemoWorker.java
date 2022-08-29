package com.example.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DemoWorker extends Worker {


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

        // Do the work here--in this case, count to 1000:
        for (int i = 0; i<1000; i++ ) {
            Log.i("TAGY", "Count is : "+i);
        }

        // The Result returned from doWork() informs the
        // WorkManager service whether the work succeeded and,
        // in the case of failure, whether or not the work should be retried.
        //  - Result.success(): The work finished successfully.
        //  - Result.failure(): The work failed.
        //  - Result.retry():   The work failed and should be tried at
        //                      another time according to its retry policy
        return Result.success();
    }
}
