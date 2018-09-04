package pl.patrykzygo.pocketleague.logic;

import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {

    Scheduler getIOScheduler();

    Scheduler getComputerScheduler();

    Scheduler getUiScheduler();

}
