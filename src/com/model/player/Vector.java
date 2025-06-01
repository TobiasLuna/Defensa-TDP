package com.model.player;

public class Vector {
	protected float x;
	protected float y;
	
	public Vector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector Sum(Vector vector)
	{
		if(isOlder(vector))
		{
			return new Vector(this.x - vector.getX(), this.y - vector.getY());
		}else
		{
			return new Vector(vector.getX() - this.x,vector.getY() - this.y);
		}
	}
	private boolean isOlder(Vector vector)
	{
		return this.x > vector.getX() && this.y > vector.y;
	}
	public float getX()
	{
		return this.x;
	}
	public float getY()
	{
		return this.y;
	}
}
