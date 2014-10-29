package io.zades.core.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import io.zades.core.CCSCore;
import io.zades.core.gamestates.PreloadGameState;
import io.zades.core.objects.Beatmap;
import io.zades.core.objects.Coords;
import io.zades.core.objects.HitObject;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Darren on 10/26/2014.
 */
public final class OsuBeatmapFileParser
{
	public static final String GENERAL_SECTION 			= "[General]";
	public static final String EDITOR_SECTION 			= "[Editor]";
	public static final String METADATA_SECTION 		= "[Metadata";
	public static final String DIFFICULTY_SECTION 		= "[Difficulty]";
	public static final String EVENTS_SECTION 			= "[Events]";
	public static final String TIMING_POINTS_SECTIONS 	= "[TimingPoints]";
	public static final String COLORS_SECTIONS 			= "[Colors]";
	public static final String HIT_OBJECTS_SECTION 		= "[HitObjects]";

	public static Beatmap parseFile(Beatmap beatmap, FileHandle fileh, CCSCore game)
	{
		List<String> objectLines = new ArrayList<String>();
		List<String> timingLines = new ArrayList<String>();
		List<String> eventLines = new ArrayList<String>();
		List<String> kvLines = new ArrayList<String>();

		String[] readLines = fileh.readString().split("\n");

		return null;
	}

	private static HitObject parseHitObject(String line)
	{
		//TODO: finish this shit
		//x, y, offset, type, hitsound, additions
		//x, y, offset, type, hitsound, slidertype, points (|x:y|x:y,...), additions
		//x, y, offset, type, hitsound, endoffset, addition
		//new combo as well as the type is encoded as bits
		//1 = circle
		//2 = slider
		//4 = new combo
		//8 = spinner

		String[] hitObjectParts = line.split(",");
		for(String ea: hitObjectParts)
		{
			ea = ea.trim();
		}
		if(hitObjectParts.length < 6)
		{
			return null;
		}

		Coords coords = new Coords(Double.parseDouble(hitObjectParts[0]), Double.parseDouble(hitObjectParts[1]));
		int offset = Integer.parseInt(hitObjectParts[2]);
		int type = Integer.parseInt(hitObjectParts[3]);
		int hitSound = Integer.parseInt(hitObjectParts[4]);
		boolean newCombo = ((type & HitObject.NEW_COMBO) == HitObject.NEW_COMBO);

		HitObject obj = new HitObject();
		obj.addCoords(coords);
		obj.setOffsetTime(offset);
		obj.setHitSoundType(hitSound);
		obj.setNewCombo(newCombo);

		if((type & HitObject.CIRCLE_HIT_OBJECT) ==  HitObject.CIRCLE_HIT_OBJECT)
		{
			obj.setHitObjectType(HitObject.CIRCLE_HIT_OBJECT);
			//TODO: parse additions
		}
		else if((type & HitObject.SLIDER_HIT_OBJECT) ==  HitObject.SLIDER_HIT_OBJECT)
		{
			obj.setHitObjectType(HitObject.SLIDER_HIT_OBJECT);
			//TODO: parse additions
			//TODO: parse edge crap
		}
		else if((type & HitObject.SPINNER_HIT_OBJECT) ==  HitObject.SPINNER_HIT_OBJECT)
		{
			obj.setHitObjectType(HitObject.SPINNER_HIT_OBJECT);
			//TODO: parse additions
		}
		else
		{
			return null;
		}

		return obj;
	}
}