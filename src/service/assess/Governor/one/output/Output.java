package service.assess.Governor.one.output;

import java.util.List;

import service.assess.Governor.one.History;
import service.assess.Governor.one.FaultSignal.SignalSum;
import service.assess.Governor.one.state.StateSum;

public class Output {
	public GovAssResult getGovAssessResult(long time) {
		SignalSum SS = new SignalSum();
		List<Number> U1 = SS.getSignalSum(time);

		StateSum SSM = new StateSum();
		List<Number> U2 = SSM.getStateSum(time);

		History history = new History();
		double U3 = history.getHistory(time);
		double score = (double) U1.get(U1.size() - 1) * 0.6483
				+ (double) U2.get(U2.size() - 1) * 0.2296 + U3 * 0.1220;
		GovAssResult govAssResult = new GovAssResult(U2, U1, U3, score);
		return govAssResult;
	}

}
