package lib.utils;

import lib.utils.doubl.Circle2DF;
import lib.utils.doubl.Rectangle2DF;

public class SimpleCollisionDetector {

	private SimpleCollisionDetector()
	{
		
	}
	
	public static void keepCircleInRect(final Circle2DF p_circle, final Rectangle2DF p_rect)
	{
		keepCircleTopInRect(p_circle, p_rect);
		keepCircleBotInRect(p_circle, p_rect);
		keepCircleLeftInRect(p_circle, p_rect);
		keepCircleRightInRect(p_circle, p_rect);
	}
	
	private static void keepCircleTopInRect(final Circle2DF p_circle, final Rectangle2DF p_rect)
	{
		double circleTopY = p_circle.Mid().Y() - p_circle.Radius();
		double rectTopY = p_rect.getPosition().Y() - p_rect.getDimension().Height() / 2;
		if(circleTopY < rectTopY)
			p_circle.Mid().setY(rectTopY + p_circle.Radius());
	}
	
	private static void keepCircleBotInRect(final Circle2DF p_circle, final Rectangle2DF p_rect)
	{
		double circleBotY = p_circle.Mid().Y() + p_circle.Radius();
		double rectBotY = p_rect.getPosition().Y() + p_rect.getDimension().Height() / 2;
		if(circleBotY > rectBotY)
			p_circle.Mid().setY(rectBotY - p_circle.Radius());
	}
	
	private static void keepCircleLeftInRect(final Circle2DF p_circle, final Rectangle2DF p_rect)
	{
		double circleLeft = p_circle.Mid().X() - p_circle.Radius();
		double rectLeft = p_rect.getPosition().X() - p_rect.getDimension().Width() / 2;
		if(circleLeft < rectLeft)
			p_circle.Mid().setX(rectLeft + p_circle.Radius());
	}
	
	private static void keepCircleRightInRect(final Circle2DF p_circle, final Rectangle2DF p_rect)
	{
		double circleRight = p_circle.Mid().X() + p_circle.Radius();
		double rectRight = p_rect.getPosition().X() + p_rect.getDimension().Width() / 2;
		if(circleRight > rectRight)
			p_circle.Mid().setX(rectRight - p_circle.Radius());
	}
	
	//TODO
	public static void keepRectInCircle(final Rectangle2DF p_rect, final Circle2DF p_circle)
	{
		
	}
	
	public static boolean collide(final Rectangle2DF p_rect, final Circle2DF p_circle)
	{
		
		return true;
	}
	
	public static boolean collide(final Rectangle2DF p_rect1, final Rectangle2DF p_rect2)
	{
		return true;
	}
	
	public static boolean collide(final Circle2DF p_circle1, final Circle2DF p_circle2)
	{
		double distx = p_circle1.Mid().X() - p_circle2.Mid().X();
		double disty = p_circle1.Mid().Y() - p_circle2.Mid().Y();
		double sqDist = distx * distx + disty * disty;
		double sqRadiusDist = p_circle1.Radius() + p_circle2.Radius();
		sqRadiusDist = sqRadiusDist * sqRadiusDist;
		return sqDist <= sqRadiusDist;
	}
	
	
}
