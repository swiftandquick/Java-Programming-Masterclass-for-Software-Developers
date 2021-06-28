package s5ce28_Paint_Job;

public class PaintJob {

    /* Method return an int, which represents the number of buckets Bob needs to buy before going to work.
    width:  Width of the wall.  height:  Height of the wall.  areaPerBucket:  Area that can be covered by one bucket
    of paint.  extraBuckets:  Bucket count that Bob has at home. */
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }
        else {
            // Round up because area covered by total buckets of paint must be greater than area covered.
            int buckets = (int) Math.ceil(((width * height - extraBuckets * areaPerBucket) / areaPerBucket));
            return buckets;
        }
    }


    /* Same as above, but without extraBuckets.  */
    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        else {
            int buckets = (int) Math.ceil((width * height) / areaPerBucket);
            return buckets;
        }
    }


    /* Same as above, but instead of width and height, there is area.  */
    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        else {
            int buckets = (int) Math.ceil(area / areaPerBucket);
            return buckets;
        }
    }


    public static void main(String[] args) {

        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));

        System.out.println(getBucketCount(-3.4, 2.1, 1.5));
        System.out.println(getBucketCount(3.4, 2.1, 1.5));
        System.out.println(getBucketCount(7.25, 4.3, 2.35));

        System.out.println(getBucketCount(3.4, 1.5));
        System.out.println(getBucketCount(6.26, 2.2));
        System.out.println(getBucketCount(3.26, 0.75));

    }

}
