import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import aima.core.learning.framework.DataSet;
import aima.core.learning.framework.DataSetFactory;
import aima.core.learning.framework.Learner;
import aima.core.learning.inductive.DLTestFactory;
import aima.core.learning.inductive.DecisionTree;
import aima.core.learning.learners.AdaBoostLearner;
import aima.core.learning.learners.DecisionListLearner;
import aima.core.learning.learners.DecisionTreeLearner;
import aima.core.learning.learners.StumpLearner;
import aima.core.learning.neural.BackPropLearning;
import aima.core.learning.neural.FeedForwardNeuralNetwork;
import aima.core.learning.neural.IrisDataSetNumerizer;
import aima.core.learning.neural.IrisNNDataSet;
import aima.core.learning.neural.NNConfig;
import aima.core.learning.neural.NNDataSet;
import aima.core.learning.neural.Numerizer;
import aima.core.learning.neural.Perceptron;
import aima.core.learning.reinforcement.agent.PassiveADPAgent;
import aima.core.learning.reinforcement.agent.PassiveTDAgent;
import aima.core.learning.reinforcement.agent.QLearningAgent;
import aima.core.learning.reinforcement.agent.ReinforcementAgent;
import aima.core.learning.reinforcement.example.CellWorldEnvironment;
import aima.core.probability.example.MDPFactory;
import aima.core.probability.mdp.impl.ModifiedPolicyEvaluation;
import aima.core.util.JavaRandomizer;
import aima.core.util.Util;

public class LearningDemo {
	public static void main(String[] args) {

		// Chapter 18
		decisionTreeDemo();

	}

	public static void decisionTreeDemo() {
		System.out.println(Util.ntimes("*", 100));
		System.out
				.println("\nDecisionTree Demo - Inducing a DecisionList from the Restaurant DataSet\n ");
		System.out.println(Util.ntimes("*", 100));
		try {
			DataSet ds = DataSetFactory.getRestaurantDataSet();
			DecisionTreeLearner learner = new DecisionTreeLearner();
			learner.train(ds);
			System.out.println("The Induced Decision Tree is ");
			System.out.println(learner.getDecisionTree());
			int[] result = learner.test(ds);

			System.out
					.println("\nThis Decision Tree classifies the data set with "
							+ result[0]
							+ " successes"
							+ " and "
							+ result[1]
							+ " failures");
			System.out.println("\n");
		} catch (Exception e) {
			System.out.println("Decision Tree Demo Failed  ");
			e.printStackTrace();
		}
	}

}
