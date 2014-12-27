package io.zades.core.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.zades.core.CCSCore;
import io.zades.core.objects.CCSSkin;
import io.zades.core.objects.HitObject;
import io.zades.core.objects.beatmaps.Beatmap;
import io.zades.core.objects.beatmaps.DifficultyTable;
import javafx.util.Pair;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Zades on 12/24/2014.
 */
public class BeatmapGraphicsManager
{
    private CCSCore game;
    private Beatmap beatmap;
    private HashMap<Long, Pair<HitObject, Boolean>> drawableHitObjects;

    private SpriteBatch batch;


    public BeatmapGraphicsManager(CCSCore game, Beatmap beatmap)
    {
        this.game = game;
        this.beatmap = beatmap;
        this.drawableHitObjects = new HashMap<>();

        this.batch = new SpriteBatch();
    }

    //This method exists so that if a long ass song is played the loading doesn't stop the default thread
    public void init()
    {
        for(HitObject hitObject: this.beatmap.getHitObjects())
        {
            //TODO: look into why there isn't a 0th index
            if(hitObject != null)
            {
                this.drawableHitObjects.put(hitObject.getOffsetTime(), new Pair<>(hitObject, false));
            }
        }
    }

    public void draw(long elapsedTime)
    {
        long maxBeforeDrawTime = elapsedTime - DifficultyTable.odDefaultTable[this.beatmap.getDifficultyData().getOverallDifficulty()][1];
        long maxAfterDrawTime = elapsedTime + DifficultyTable.arDefaultTable[this.beatmap.getDifficultyData().getApproachRate()];

        this.batch.begin();

        //TODO: might be more effiecnt to iterate over the list of hitobjects
        for(long time = maxBeforeDrawTime; time <= maxAfterDrawTime; time++)
        {
            if(this.drawableHitObjects.containsKey(time))
            {
                this.drawHitObject(elapsedTime, this.drawableHitObjects.get(time).getKey());
            }
        }

        this.batch.end();
    }

    private void drawHitObject(long elapsedTime, HitObject hitObject)
    {
        switch(hitObject.getHitObjectType())
        {
            case HitObject.CIRCLE_HIT_OBJECT:
                this.drawHitCircleObject(elapsedTime, hitObject);
                break;
            default:
                this.drawHitCircleObject(elapsedTime, hitObject);
                break;

        }
    }

    private void drawHitCircleObject(long elapsedTime, HitObject hitObject)
    {
        float hitObjectX = (float)hitObject.getCoords().get(0).getGdxX();
        float hitObjectY = (float)hitObject.getCoords().get(0).getGdxY();

        //draw the appraoch circle
        if(hitObject.getOffsetTime() >= elapsedTime)
        {
            Texture approachCircle = this.game.assetManager.get(this.game.ccsSkinManager.getCurrentCCSSkin().getLocation() + CCSSkin.APPROACH_CIRCLE, Texture.class);

            //The scale is the |currentTime - finalTime|/arTime * 3 + 1
            float scaleRatio = (float)Math.abs(elapsedTime - hitObject.getOffsetTime())/(float)DifficultyTable.arDefaultTable[this.beatmap.getDifficultyData().getApproachRate()] * 3 + 1;
            Gdx.app.debug(BeatmapGraphicsManager.class.toString(), "Curent Ratio for " + hitObject.getOffsetTime() + " is: " + scaleRatio);

            this.batch.draw(approachCircle, hitObjectX - (approachCircle.getWidth() * scaleRatio)/2, hitObjectY - (approachCircle.getHeight() * scaleRatio)/2,
                    approachCircle.getWidth() * scaleRatio, approachCircle.getHeight() * scaleRatio);

        }

        //draw only the circle
        //TODO: overlay circle?
        Texture hitCircle = this.game.assetManager.get(this.game.ccsSkinManager.getCurrentCCSSkin().getLocation() + CCSSkin.HIT_CIRCLE, Texture.class);
        Gdx.app.debug(BeatmapGraphicsManager.class.toString(), "Attempting to draw:" + hitObject.getOffsetTime() + " with (" + hitObject.getCoords().get(0).getX() + ", " + hitObject.getCoords().get(0).getY() + ")" +  " at: " + (float)hitObject.getCoords().get(0).getGdxX() + " " + (float)hitObject.getCoords().get(0).getGdxY() );
        Gdx.app.debug(BeatmapGraphicsManager.class.toString(), "Elapsed Time " + elapsedTime);

        this.batch.draw(hitCircle,  hitObjectX - hitCircle.getWidth()/2, hitObjectY - hitCircle.getHeight()/2);
    }
}
