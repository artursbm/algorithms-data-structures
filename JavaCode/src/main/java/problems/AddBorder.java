package problems;

public class AddBorder {

  String[] solution(String[] picture) {

    // borderedPicture will have length = picture.length + 2, and also inner words.
    String bS = "*";
    String[] borderedPicture = new String[picture.length + 2];
    final int picWithBorderLength = picture[0].length() + 2;

    //adding first and last border
    borderedPicture[0] = bS.repeat(picWithBorderLength);
    borderedPicture[borderedPicture.length - 1] = bS.repeat(picWithBorderLength);

    // adding border in each line of picture
    for (int i = 0; i < picture.length; i++) {
      StringBuilder b = new StringBuilder(picWithBorderLength);
      b.append(bS).append(picture[i]).append(bS);
      borderedPicture[i + 1] = b.toString();
    }

    return borderedPicture;
  }
}
