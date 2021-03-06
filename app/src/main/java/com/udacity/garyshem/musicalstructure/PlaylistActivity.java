package com.udacity.garyshem.musicalstructure;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        View current = findViewById(R.id.playlist);
        current.setBackgroundColor(Color.CYAN);

        TextView desciption = (TextView)findViewById(R.id.music_library_description);
        desciption.setText(getResources().getString(R.string.playlist_description));

        hookHeaders();
        hookCurrentPlayback();
    }
    private void hookHeaders(){
        View artists = findViewById(R.id.artists);
        View folders = findViewById(R.id.folders);
        View tracks = findViewById(R.id.tracks);
        View playlist = findViewById(R.id.playlist);
        View albums = findViewById(R.id.albums);

        //make listeners for every header
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(PlaylistActivity.this, ArtistsLibraryActivity.class);
                startActivity(artistIntent);
            }
        });
        folders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent foldersIntent = new Intent(PlaylistActivity.this, FoldersLibraryActivity.class);
                startActivity(foldersIntent);
            }
        });
        tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tracksIntent = new Intent(PlaylistActivity.this, TracksLibraryActivity.class);
                startActivity(tracksIntent);
            }
        });
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(PlaylistActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(PlaylistActivity.this, AlbumsLibraryActivity.class);
                startActivity(albumsIntent);
            }
        });
    }
    private void hookCurrentPlayback() {
        // add listener to the bottom menu (icon can be clicked to move to current playback)
        View currentSongIcon = findViewById(R.id.current_song_icon);
        currentSongIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playbackIntent = new Intent(PlaylistActivity.this, CurrentPlaybackActivity.class);
                startActivity(playbackIntent);
            }
        });
    }
}
