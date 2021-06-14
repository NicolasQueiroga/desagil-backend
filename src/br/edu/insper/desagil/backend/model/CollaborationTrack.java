package br.edu.insper.desagil.backend.model;

import java.util.List;

public class CollaborationTrack extends Track
{

	private List<Artist> collaborators;

	
	public CollaborationTrack(Artist artist, String name, int duration, List<Artist> collaborators) 
	{
		super(artist, name, duration);
		this.collaborators = collaborators;
	}
	
	@Override
	public String getFullArtistName()
	{
		String colab = super.getFullArtistName() + " (feat. " + this.collaborators.get(0).getName();
		for (int i = 1; i < this.collaborators.size(); i++)
		{
			colab += ", ";
			colab += this.collaborators.get(i).getName();
		}
		colab += ")";
		return colab;
	}
}
