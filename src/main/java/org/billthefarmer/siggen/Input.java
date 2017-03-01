////////////////////////////////////////////////////////////////////////////////
//
//  Signal generator - An Android Signal generator written in Java.
//
//  Copyright (C) 2013	Bill Farmer
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
//  Bill Farmer	 william j farmer [at] yahoo [dot] co [dot] uk.
//
///////////////////////////////////////////////////////////////////////////////

package org.billthefarmer.siggen;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.view.inputmethod.EditorInfo;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.View;

public class Input extends Activity
    implements TextView.OnEditorActionListener

{
    // On create
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        TextView text = (TextView)findViewById(R.id.input);
        if (text != null)
            text.setOnEditorActionListener(this);
    }

    // onEditorAction
    public boolean onEditorAction(TextView view, int actionId, KeyEvent event)
    {
        // Get id
        switch (actionId)
        {
        case EditorInfo.IME_ACTION_DONE:
            if (view.length() > 0)
            {
                Intent intent = new Intent();
                intent.putExtra(Main.EXACT, view.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
            break;
        }

        setResult(RESULT_CANCELED);
        finish();

        return false;
    }
}
