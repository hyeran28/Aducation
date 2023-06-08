package com.example.aducation;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private RecyclerView mMainRecyclerView;
        private MainAdapter mAdapter;
        private List<BoardActivity> mBoardList;
        private FloatingActionButton mWriteButton;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mMainRecyclerView = findViewById(R.id.main_recycler_view);
            mWriteButton = findViewById(R.id.main_write_button);

            mWriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, WriteActivity.class);
                    startActivity(intent);
                }
            });

            mBoardList = new ArrayList<>();
            mBoardList.add(new BoardActivity(null, "test1", null, "android"));
            mBoardList.add(new BoardActivity(null, "test2", null, "ios"));
            mBoardList.add(new BoardActivity(null, "test3", null, "Name"));
            mBoardList.add(new BoardActivity(null, "test1", null, "pizza"));
            mBoardList.add(new BoardActivity(null, "test2", null, "python"));
            mBoardList.add(new BoardActivity(null, "coke", null, "ham"));
            mBoardList.add(new BoardActivity(null, "java", null, "yolo"));
            mBoardList.add(new BoardActivity(null, "cake", null, "coffee"));
            mBoardList.add(new BoardActivity(null, "abc", null, "123"));

            mAdapter = new MainAdapter(mBoardList);
            mMainRecyclerView.setAdapter(mAdapter);
        }

        @Override
        public void onClick(View v) {

        }

        private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
            private List<BoardActivity> mBoardList;

            public MainAdapter(List<BoardActivity> mBoardList) {
                this.mBoardList = mBoardList;
            }

            @NonNull
            @Override
            public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment1, parent, false));
            }

            @Override
            public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
                BoardActivity data = mBoardList.get(position);
                holder.mTitleTextView.setText(data.getTitle());
                holder.mNameTextView.setText(data.getName());
            }

            @Override
            public int getItemCount() {
                return mBoardList.size();
            }

            class MainViewHolder extends RecyclerView.ViewHolder {
                private TextView mTitleTextView;
                private TextView mNameTextView;

                public MainViewHolder(View itemView) {
                    super(itemView);

                    mTitleTextView = itemView.findViewById(R.id.item_title_text);
                    mNameTextView = itemView.findViewById(R.id.item_name_text);
                }
            }
        }
    }
}
