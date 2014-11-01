package io.zades.core.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import io.zades.core.CCSCore;
import io.zades.core.objects.beatmaps.Beatmap;
import io.zades.core.objects.Coords;
import io.zades.core.objects.HitObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: refactor is out of static
 * Created by Darren on 10/26/2014.
 */
public final class OsuBeatmapFileParser
{
	public static final String OSU_VERSION_PATTERN		= "\\Aosu file format v\\(d+\\)\\z";
	public static final String SECTION_PATTERN			= "\\A\\[[a-zA-z0-9]+\\]\\z";
	public static final String KEY_GROUP_NAME			= "KEY";
	public static final String VALUE_GROUP_NAME			= "VALUE";
	public static final String KV_PATTERN				= "\\A(?<" + KEY_GROUP_NAME + ">.+)\\s*:\\s*(?<" + VALUE_GROUP_NAME + ">.+)\\s*\\z";


	public static final String BLANK_SECTION			= "";
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
		//sanity checks
		if(beatmap == null)
		{
			beatmap = new Beatmap();
		}

		//stuff
		String currentSection = "";
		List<String> objectLines = new ArrayList<String>();
		List<String> timingLines = new ArrayList<String>();
		List<String> eventLines = new ArrayList<String>();
		List<String> kvLines = new ArrayList<String>();

		String[] readLines = fileh.readString().split("\n");

		for(String line: readLines)
		{
			line = line.trim();

			if(line.equals("") || line == null)
			{
				continue;
			}

			if (currentSection.equals("") && beatmap.getOsuFileVersion() == -1)
			{
				Pattern pattern = Pattern.compile(OSU_VERSION_PATTERN);
				Matcher matcher = pattern.matcher(line);
				if(matcher.find())
				{
					beatmap.setOsuFileVersion(Integer.parseInt(matcher.group()));
					continue;
				}
			}

			Pattern sectionPattern = Pattern.compile(SECTION_PATTERN);
			Matcher sectionsMatcher = sectionPattern.matcher(line);
			if(sectionsMatcher.matches())
			{
				currentSection = line;
			}

			switch (currentSection)
			{
				case BLANK_SECTION:
					break;
				case EVENTS_SECTION:
					eventLines.add(line);
					break;
				case TIMING_POINTS_SECTIONS:
					timingLines.add(line);
					break;
				case HIT_OBJECTS_SECTION:
					objectLines.add(line);
					break;
				case GENERAL_SECTION:
					break;
				case METADATA_SECTION:
					break;
				case DIFFICULTY_SECTION:
					break;
				case COLORS_SECTIONS:
					break;
				default:
					kvLines.add(line);
					break;
			}
		}

		parseKVPairs(beatmap, kvLines);
		parseHitObjects(beatmap, objectLines);

		return beatmap;
	}

	private static void parseKVPairs(Beatmap beatmap, List<String> lines)
	{
		Pattern pattern = Pattern.compile(KV_PATTERN);

		for(String line: lines)
		{
			line = line.trim();

			Matcher matcher = pattern.matcher(line);
			if(matcher.find())
			{
				String key = matcher.group(KEY_GROUP_NAME);
				String value = matcher.group(VALUE_GROUP_NAME);

				if (beatmap.getKvPairs().containsKey(key))
				{
					Gdx.app.log(OsuBeatmapFileParser.class.toString(), "WARNING: Key " + key + " already exists in beatmap");
				} else
				{
					beatmap.getKvPairs().put(key, value);
				}
			}
		}
	}

	private static void parseHitObjects(Beatmap beatmap, List<String> lines)
	{
		for(String line: lines)
		{
			line = line.trim();

			HitObject hitObject = parseHitObject(line);
			beatmap.getHitObjects().add(hitObject);
		}
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
		for(String str: hitObjectParts)
		{
			str = str.trim();
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
		obj.getCoords().add(coords);
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