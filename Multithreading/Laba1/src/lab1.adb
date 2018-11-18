with Ada.Text_IO;
use Ada.Text_IO;
with Data;
use Data;
with Ada.Integer_Text_IO;
with System.Multiprocessors;
use System.Multiprocessors;

procedure lab1 is
   cpu1 : CPU_Range := 0;
   cpu2 : CPU_Range := 1;
   cpu3 : CPU_Range := 2;

   N : Integer := 100;

   task T1 is
      pragma Priority(3);
      pragma Storage_Size(900_000_000);
      pragma CPU(cpu1);
   end T1;

   task T2 is
      pragma Priority(2);
      pragma Storage_Size(900_000_000);
      pragma CPU(cpu2);
   end T2;

   task T3  is
      pragma Priority(1);
      pragma Storage_Size(900_000_000);
      pragma CPU(cpu3);
   end T3;


   task body T1 is
      O, E : Matrix;
      A, B, C : Vector;
   begin
      Put_Line ("Task 1:");
      Matrix_Generate(O, N);
      Matrix_Generate(E, N);
      Vector_Generate(A, N);
      Vector_Generate(B, N);
      Put_Line("Input data :");
      Matrix_Output(O, N, "Matrix O: ");
      Matrix_Output(E, N, "Matrix E: ");
      Vector_Output(A, N, "Vector A: ");
      Vector_Output(B, N, "Vector B: ");

      C := F1(O, E, A, B, N);

      Vector_Output(C, N, "Result Vector C:");
      Put_Line("End task 1");
   end T1;

   task body T2 is
      G, K, L, F : Matrix;
   begin

      Put_Line ("Task 2:");
      Matrix_Generate(G, N);
      Matrix_Generate(K, N);
      Matrix_Generate(L, N);

      F := F2(G, K, L, N);

      Matrix_Output(F, N, "Resut Matrix F:");
      Put_Line("End task 2");
   end T2;

   task body T3 is
      P, R : Matrix;
      T, O : Vector;

   begin

      Put_Line ("Task 3:");
      Matrix_Generate(P, N);
      Matrix_Generate(R, N);
      Vector_Generate(T, N);
      O := F3(P, R, T, N);

      Vector_Output(O, N, "Result Vector O:");
      Put_Line("End task 3");
   end T3;

begin
   Put_Line("Lab1");
   -- lab1;
end lab1;
