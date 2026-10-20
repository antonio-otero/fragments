package com.example.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.FragmentEncryptBinding
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController

class EncryptFragment : Fragment() {
    //Declaración de argumentos
    private val args: EncryptFragmentArgs by navArgs()

    private var _binding: FragmentEncryptBinding? = null
    private val binding get() = checkNotNull(_binding) {
        "No se puede acceder al binding porque es nulo. ¿Está visible la vista?"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEncryptBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOriginal.text = args.texto
        binding.tvCifrado.text = cifrarCesar(args.texto, args.desplazamiento)
        binding.btVolver.setOnClickListener {
            findNavController().navigateUp()
        }




        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

