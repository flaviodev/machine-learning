package br.com.flaviodev.courses.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;

/**
 * Hello world!
 *
 */
public class CoursesRecommender {
	public static void main(String[] args) throws TasteException, IOException {
		File file = new File("src/main/resources/courses.csv");
		FileDataModel model = new FileDataModel(file);

		UserBasedRecommender recommender = (UserBasedRecommender) new MyRecommenderBuilder().buildRecommender(model);
	
		List<RecommendedItem> recommendations = recommender.recommend(1, 3);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
	}
}
