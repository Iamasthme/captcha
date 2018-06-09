package captcha.com.capthaking.json;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import captcha.com.capthaking.model.Question;

public class JsonParser {


    public static ArrayList<Question> loadJSONFromAsset(Context context) {
        ArrayList<Question> locList = new ArrayList<>();
        String json = null;
        try {
            InputStream is = context.getAssets().open("captcha.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            JSONArray m_jArry = new JSONArray(json);
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Question question = new Question();
                question.setId(jo_inside.getInt("id"));
                question.setName(jo_inside.getString("name"));
                question.setAnswer(jo_inside.getString("answer"));
                question.setDifficulty(jo_inside.getInt("difficulty"));
                locList.add(question);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return locList;
    }
}
