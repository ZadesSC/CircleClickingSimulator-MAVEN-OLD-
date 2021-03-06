package io.zades.core.objects;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Object representing a skin
 * Created by Darren on 10/20/2014.
 */
public class CCSSkin
{
	//TODO: add all other data file pathes, currently it only has the most basic items
	public static final String SKIN_INIT_FILE			= "skin.ini";

	//Paths for textures for the skin (names based off osu skin names which for some reason are not consistant)
	public static final String APPROACH_CIRCLE 			= "approachcircle.png";
	public static final String HIT_CIRCLE 				= "hitcircle.png";
	public static final String HIT_CIRCLE_OVERLAY 		= "hitcircleoverlay.png";

	public static final String CURSOR 					= "cursor.png";
	public static final String CURSOR_TRAIL 			= "cursortrail.png";

	public static final String HIT_0 					= "hit0.png";
	public static final String HIT_50 					= "hit50.png";
	public static final String HIT_100 					= "hit100.png";
	public static final String HIT_100_K 				= "hit100k.png";
	public static final String HIT_300 					= "hit300.png";
	public static final String HIT_300_K 				= "hit300k.png";

	public static final String SLIDER_B_0 				= "sliderb0.png";
	public static final String SLIDER_FOLLOW_CIRCLE 	= "sliderfollowcircle.png";
	public static final String SLIDER_POINT_10 			= "sliderpoint10.png";
	public static final String SLIDER_POINT_30 			= "sliderpoint30.png";
	public static final String SLIDER_SCORE_POINT 		= "sliderscorepoint.png";

	public static final String SPINNER_APPROACH_CIRCLE 	= "spinner-approachcircle.png";
	public static final String SPINNER_CIRCLE 			= "spinner-circle.png";
	public static final String SPINNER_BACKGROUND 		= "spinner-background.png";
	public static final String SPINNER_CLEAR 			= "spinner-clear.png";
	public static final String SPINNER_METRE 			= "spinner-metre.png";
	public static final String SPINNER_OSU 				= "spinner-osu.png";
	public static final String SPINNER_RPM 				= "spinner-rpm.png";
	public static final String SPINNER_SPIN 			= "spinner-spin.png";

	public static final String FOLLOW_POINT 			= "followpoint.png";
	public static final String FOLLOW_POINT_DASH 		= "followpoint-.png";
	public static final String FOLLOW_POINT_0 			= "followpoint-0.png";
	public static final String FOLLOW_POINT_1 			= "followpoint-1.png";
	public static final String FOLLOW_POINT_2 			= "followpoint-2.png";
	public static final String FOLLOW_POINT_3 			= "followpoint-3.png";
	public static final String FOLLOW_POINT_4 			= "followpoint-4.png";
	public static final String FOLLOW_POINT_5 			= "followpoint-5.png";
	public static final String FOLLOW_POINT_6 			= "followpoint-6.png";
	public static final String FOLLOW_POINT_7 			= "followpoint-7.png";
	public static final String FOLLOW_POINT_8 			= "followpoint-8.png";
	public static final String FOLLOW_POINT_9 			= "followpoint-9.png";

	public static final String DEFAULT_0 				= "default-0.png";
	public static final String DEFAULT_1 				= "default-1.png";
	public static final String DEFAULT_2 				= "default-2.png";
	public static final String DEFAULT_3 				= "default-3.png";
	public static final String DEFAULT_4 				= "default-4.png";
	public static final String DEFAULT_5		 		= "default-5.png";
	public static final String DEFAULT_6 				= "default-6.png";
	public static final String DEFAULT_7 				= "default-7.png";
	public static final String DEFAULT_8 				= "default-8.png";
	public static final String DEFAULT_9 				= "default-9.png";

	public static final String SCORE_0 					= "score-0.png";
	public static final String SCORE_1 					= "score-1.png";
	public static final String SCORE_2 					= "score-2.png";
	public static final String SCORE_3 					= "score-3.png";
	public static final String SCORE_4 					= "score-4.png";
	public static final String SCORE_5 					= "score-5.png";
	public static final String SCORE_6 					= "score-6.png";
	public static final String SCORE_7 					= "score-7.png";
	public static final String SCORE_8 					= "score-8.png";
	public static final String SCORE_9 					= "score-9.png";
	public static final String SCORE_DOT 				= "score-dot.png";
	public static final String SCORE_PERCENT 			= "score-percent.png";
	public static final String SCORE_X 					= "score-x.png";
	public static final String SCOREBAR_BG 				= "scorebar-bg.png";

	public static final String READY 					= "ready.png";
	public static final String COUNT_1 					= "count1.png";
	public static final String COUNT_2 					= "count2.png";
	public static final String COUNT_3 					= "count3.png";
	public static final String GO 						= "go.png";

	public static final String BUTTON_LEFT 				= "button-left.png";
	public static final String BUTTON_MIDDLE 			= "button-middle.png";
	public static final String BUTTON_RIGHT				= "button-right.png";

	public static final String MENU_BACK 				= "menu-back.png";
	public static final String MENU_BUTTON_BACKGROUND 	= "menu-button-background.png";

	public static final String PAUSE_BACK 				= "pause-back.png";
	public static final String PAUSE_CONTINUE 			= "pause-continue.png";
	public static final String PAUSE_RETRY 				= "pause-retry.png";

	public static final String PLAY_FIELD 				= "playfield.png";
	public static final String PLAY_SKIP 				= "play-skip.png";
	public static final String PLAY_WARNING_ARROW 		= "play-warningarrow.png";
	public static final String REVERSE_ARROW 			= "reversearrow.png";

	public static final String STAR 					= "star.png";
	public static final String STAR_2 					= "star2.png";

	//Path for sound
	public static final String READYS					= "ready.wav";
	public static final String COUNT_1_S				= "count1s.wav";
	public static final String COUNT_2_S				= "count2s.wav";
	public static final String COUNT_3_S				= "count3s.wav";
	public static final String GOS						= "gos.wav";

	public static final String NORMAL_HIT_CLAP			= "normal-hitclap.wav";
	public static final String NORMAL_HIT_FINISH		= "normal-hitfinish.wav";
	public static final String NORMAL_HIT_NORMAL		= "normal-hitnormal.wav";
	public static final String NORMAL_HIT_WHISTLE		= "normal-hitwhistle.wav";
	public static final String NORMAL_SLIDER_SLIDE		= "normal-sliderslide.wav";
	public static final String NORMAL_SLIDER_TICK		= "normal-slidertick.wav";
	public static final String NORMAL_SLIDER_WHISTLE	= "normal-sliderwhistle.wav";

	public static final String SOFT_HIT_CLAP			= "soft-hitclap.wav";
	public static final String SOFT_HIT_FINISH			= "soft-hitfinish.wav";
	public static final String SOFT_HIT_NORMAL			= "soft-hitnormal.wav";
	public static final String SOFT_HIT_WHISTLE			= "soft-hitwhistle.wav";
	public static final String SOFT_SLIDER_SLIDE		= "soft-sliderslide.wav";
	public static final String SOFT_SLIDER_TICK			= "soft-slidertick.wav";
	public static final String SOFT_SLIDER_WHISTLE		= "soft-sliderwhistle.wav";

	//Combined list for easy processing
	public static final String[] LIST_OF_TEXTURES =
	{
				APPROACH_CIRCLE,
				HIT_CIRCLE,
				HIT_CIRCLE_OVERLAY,
				CURSOR,
				CURSOR_TRAIL,
				HIT_0,
				HIT_50,
				HIT_100,
				HIT_100_K,
				HIT_300,
				HIT_300_K,
				SLIDER_B_0,
				SLIDER_FOLLOW_CIRCLE,
				SLIDER_POINT_10,
				SLIDER_POINT_30,
				SLIDER_SCORE_POINT,
				SPINNER_APPROACH_CIRCLE,
				SPINNER_CIRCLE,
				SPINNER_BACKGROUND,
				SPINNER_CLEAR,
				SPINNER_METRE,
				SPINNER_OSU,
				SPINNER_RPM,
				SPINNER_SPIN,
				FOLLOW_POINT,
				FOLLOW_POINT_DASH,
				FOLLOW_POINT_0,
				FOLLOW_POINT_1,
				FOLLOW_POINT_2,
				FOLLOW_POINT_3,
				FOLLOW_POINT_4,
				FOLLOW_POINT_5,
				FOLLOW_POINT_6,
				FOLLOW_POINT_7,
				FOLLOW_POINT_8,
				FOLLOW_POINT_9,
				DEFAULT_0,
				DEFAULT_1,
				DEFAULT_2,
				DEFAULT_3,
				DEFAULT_4,
				DEFAULT_5,
				DEFAULT_6,
				DEFAULT_7,
				DEFAULT_8,
				DEFAULT_9,
				SCORE_0,
				SCORE_1,
				SCORE_2,
				SCORE_3,
				SCORE_4,
				SCORE_5,
				SCORE_6,
				SCORE_7,
				SCORE_8,
				SCORE_9,
				SCORE_DOT,
				SCORE_PERCENT,
				SCORE_X,
				SCOREBAR_BG,
				READY,
				COUNT_1,
				COUNT_2,
				COUNT_3,
				GO,
				BUTTON_LEFT,
				BUTTON_RIGHT,
				BUTTON_MIDDLE,
				MENU_BACK,
				MENU_BUTTON_BACKGROUND,
				PAUSE_BACK,
				PAUSE_CONTINUE,
				PAUSE_RETRY,
				PLAY_FIELD,
				PLAY_SKIP,
				PLAY_WARNING_ARROW,
				REVERSE_ARROW,
				STAR,
				STAR_2
	};
	public static final String[] LIST_OF_SOUNDS =
	{
				READYS,
				COUNT_1_S,
				COUNT_2_S,
				COUNT_3_S,
				GOS,
				NORMAL_HIT_CLAP,
				NORMAL_HIT_FINISH,
				NORMAL_HIT_NORMAL,
				NORMAL_HIT_WHISTLE,
				NORMAL_SLIDER_SLIDE,
				NORMAL_SLIDER_TICK,
				NORMAL_SLIDER_WHISTLE,
				SOFT_HIT_CLAP,
				SOFT_HIT_FINISH,
				SOFT_HIT_NORMAL,
				SOFT_HIT_WHISTLE,
				SOFT_SLIDER_SLIDE,
				SOFT_SLIDER_TICK,
				SOFT_SLIDER_WHISTLE
	};

	//public variables
	private String skinName;
	private String location;

	private HashMap<String, Texture> listOfTextures;

	/**
	 * CCSSkin has to be created with the location (the directory of the skin
	 * @param location The directory of the skin
	 */
	public CCSSkin(String location)
	{
		this.setListOfTextures(new HashMap<String, Texture>());
		this.setLocation(location);
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public HashMap<String, Texture> getListOfTextures()
	{
		return listOfTextures;
	}

	public void setListOfTextures(HashMap<String, Texture> listOfTextures)
	{
		this.listOfTextures = listOfTextures;
	}
}
