package com.example.mathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathtrainer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Problem problem = new Problem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        generateProblem();
        MyClickListener listener = new MyClickListener();
        binding.next.setOnClickListener(listener);
        binding.sol1.setOnClickListener(listener);
        binding.sol2.setOnClickListener(listener);
        binding.sol3.setOnClickListener(listener);
    }

    private void generateProblem() {
        binding.problem.setText(problem.getProblem());

        binding.sol1.setBackground(getDrawable(R.drawable.answer_style));
        binding.sol2.setBackground(getDrawable(R.drawable.answer_style));
        binding.sol3.setBackground(getDrawable(R.drawable.answer_style));
        int pos = problem.getRandom(1, 4);
        switch (pos) {
            case 1:
                binding.sol1.setText(String.valueOf(problem.getResult()));
                binding.sol2.setText(String.valueOf(problem.getNoiseResult()));
                binding.sol3.setText(String.valueOf(problem.getNoiseResult()));
                break;
            case 2:
                binding.sol2.setText(String.valueOf(problem.getResult()));
                binding.sol1.setText(String.valueOf(problem.getNoiseResult()));
                binding.sol3.setText(String.valueOf(problem.getNoiseResult()));
                break;
            case 3:
                binding.sol3.setText(String.valueOf(problem.getResult()));
                binding.sol1.setText(String.valueOf(problem.getNoiseResult()));
                binding.sol2.setText(String.valueOf(problem.getNoiseResult()));
                break;

        }

    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.next:
                    generateProblem();
                    break;
                case R.id.sol1:
                case R.id.sol2:
                case R.id.sol3:
                    String text = ((TextView) view).getText().toString();
                    if (text.equals(String.valueOf(problem.getResult()))) {
                        view.setBackground(getDrawable(R.drawable.correct));
                        Toast.makeText(MainActivity.this, "Правильно", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        view.setBackground(getDrawable(R.drawable.wrong));
                        Toast.makeText(MainActivity.this, "Неправильно", Toast.LENGTH_SHORT).show();
                    }
            }
        }
    }
}