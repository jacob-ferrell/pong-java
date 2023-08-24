public class PaddleSection {
    public Range range;
    public Angle angleOfReflection;
    public PaddleSection(Range range, int index) {
        this.range = range;
        double[] reflectionAngles = Constants.PADDLE_SECTION_REFLECTION_ANGLES;
        angleOfReflection = new Angle(reflectionAngles[index]);
    }
}
