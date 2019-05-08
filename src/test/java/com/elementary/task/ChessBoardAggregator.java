package com.elementary.task;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

class ChessBoardAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor arguments, ParameterContext parameterContext)
            throws ArgumentsAggregationException {

        return new ChessBoard(arguments.getInteger(0), arguments.getInteger(1), true);
    }
}
