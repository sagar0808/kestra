package io.kestra.core.models.executions.statistics;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import io.kestra.core.models.flows.State;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class DailyExecutionStatistics {
    @NotNull
    protected LocalDate startDate;

    @NotNull
    private Duration duration;

    @Builder.Default
    @JsonInclude
    private Map<State.Type, Long> executionCounts = new HashMap<>(Map.of(
        State.Type.CREATED, 0L,
        State.Type.RUNNING, 0L,
        State.Type.RESTARTED, 0L,
        State.Type.KILLING, 0L,
        State.Type.SUCCESS, 0L,
        State.Type.WARNING, 0L,
        State.Type.FAILED, 0L,
        State.Type.KILLED, 0L,
        State.Type.PAUSED, 0L
    ));

    @Value
    @Builder
    static public class Duration {
        @NotNull
        java.time.Duration min;

        @NotNull
        java.time.Duration avg;

        @NotNull
        java.time.Duration max;

        @NotNull
        java.time.Duration sum;

        @NotNull
        long count;
    }
}
