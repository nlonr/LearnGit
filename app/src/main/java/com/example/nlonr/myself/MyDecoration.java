package com.example.nlonr.myself;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nlonr.R;

import java.util.Objects;

public class MyDecoration extends RecyclerView.ItemDecoration {
    
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);

        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            outRect.set(0, 40, 0, 10);
        } else if (childAdapterPosition == Objects.requireNonNull(parent.getAdapter()).getItemCount() - 1) {
            outRect.set(0, 10, 0, 40);
        } else {
            outRect.set(0, 10, 0, 10);
        }


//        outRect.set(0, 0, 0, parent.getContext().getResources().getDimensionPixelOffset(R.dimen.dp_1));
    }
}
