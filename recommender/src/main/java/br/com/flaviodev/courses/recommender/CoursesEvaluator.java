package br.com.flaviodev.courses.recommender;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.common.RandomUtils;

public class CoursesEvaluator {

	public static void main(String[] args) throws IOException, TasteException {
		
		RandomUtils.useTestSeed();
		
		File file = new File("src/main/resources/courses.csv");
		FileDataModel model = new FileDataModel(file);
		
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		
		RecommenderBuilder builder = new MyRecommenderBuilder();
		// 0.9 trainning - 1.0 testing
		double marginOfError = evaluator.evaluate(builder, null, model, 0.9, 1.0); 
		System.out.println(marginOfError);
	}
	
}
